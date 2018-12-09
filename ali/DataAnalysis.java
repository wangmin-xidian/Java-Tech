import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Wang Min
 * @date 2018/11/07 
 * @update 2018/12/08
 * @description  建议使用回归的办法来做数值分析。
 * 输入数据格式
 * 第一行两个整数，F（采集的地段特征属性数量），N（已采集到完整数据多少条）。
 * 第二到N+1行是这N行已完整采集的数据。第N+2行是，待预测数据行数量，然后是待预测数据每一行。
 * 限制： 1<=F<=10, 5<=N<=100
 *
 */
public class DataAnalysis {
	
	private double[][] trainData;
	
	private int row;
	
	private int column;
	
	private double[] theta;
	
	private double alpha = 0.001;
	
	private int iteration = 100000;
	
	private Scanner scanner = new Scanner(System.in);
	
	// 考虑使用占位符
	private final String FEATURE_NUM_MESSAGE = "Invalid input feature number : ";
	
	private final String FEATURE_NUM_RANGE_MESSAGE = "Input feature number value must in 1-10.";
	
	private final String FEATURE_VALUE_MESSAGE = "Feature value must be in [0, 1]";
	
	private final String DATA_LINE_NUM_MESSAGE = "Invalid input sample data number.";
	
	private final String DATA_LINE_NUM_RANGE_MESSAGE = "Input sample count value must in 5-100.";
	
	public void init() {
		// 1. Input feature numbers and data line number
		// 第一行两个整数，F（采集的地段特征属性数量），N（已采集到完整数据多少条）
		String firstLine = scanner.nextLine();
		String[] arrays = firstLine.split(" ");
		if (arrays.length == 0 || arrays.length != 2) {
			System.out.println("Invalid input!");
			return;
		}
		
		// validate feature number: 1<=F<=10
		int featureNum = transInput2Integer(arrays[0], FEATURE_NUM_MESSAGE);
		if (featureNum< 1 || featureNum > 10) {
			System.out.println(FEATURE_NUM_RANGE_MESSAGE + featureNum);
		}
		
		// features + y 
		column = featureNum + 1;
		
		// validate sample data number: 5<=N<=100
		int sampleNum = transInput2Integer(arrays[1], DATA_LINE_NUM_MESSAGE);	
		if (sampleNum< 5 || sampleNum > 100) {
			System.out.println(DATA_LINE_NUM_RANGE_MESSAGE + sampleNum);
		}
		
		row = sampleNum;  
		// 加了一个特征x0，x0恒等于1
		trainData = new double[row][column + 1];
		theta = new double [column];
		initTheta();
		initTrainData();
//		printTrainData();
	}
	
    private void printTrainData() {
        System.out.println("Train Data:\n");
        for(int i=0;i<column;i++) {
        	System.out.printf("%10s","x"+i+" ");        	
        }
        System.out.printf("%10s","y"+" \n");
        for(int i=0;i<row;i++) {
            for(int j=0;j<=column;j++) {
                System.out.printf("%10s",trainData[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
	
	public void trainData() {
		while ((iteration --) > 0) {
			double[] partialDerivative = computePartialDerivative();
			
			for (int i = 0; i < theta.length; i++) {
				theta[i] -= alpha * partialDerivative[i];
			}
		}
	}
	
	public void predicate() {
		// 3. Input foresight data line number 第N+2行是，待预测数据行数量
		Integer foreSightSampleNum = transInput2Integer(scanner.nextLine(), DATA_LINE_NUM_MESSAGE);
		
		// 4. Input foresight data line 待预测数据每一行
		Integer foresightSampleSize = 0;
		List<String> foresightSample = new ArrayList<>(10);
		while (scanner.hasNextLine() && foresightSampleSize < foreSightSampleNum) {
			foresightSample.add(scanner.nextLine())	;			
			foresightSampleSize++;
		}	
		
		foresightSample.forEach(element -> {
			String[] rowDatas = element.split(" ");
			double[] rowData = new double[column-1];
			for (int i =0 ; i < column -1; i++) {
				rowData[i] = transInputFeature(rowDatas[i], "");
			}
			computeForesightResult(rowData);
		});
		
	}
	
	private void initTheta() {
		for (int i = 0; i < theta.length; i++) {
        	theta[i] = 1.0;        	
        }
	}
	
	private void initTrainData() {
		// init trainData 0 column is 1.0;	
		for (int i =0 ;i < row; i++) {
			trainData[i][0] = 1.0;
		}
	
		// 2. Input sample data : 第二到N+1行是这N行已完整采集的数据
		int sampleSize = 0;
		while (scanner.hasNextLine() && sampleSize < row) {
			String[] rowDatas = scanner.nextLine().split(" ");		
			// xi
			for (int i = 0; i < column - 1 ; i++) {
				trainData[sampleSize][i+1] = transInputFeature(rowDatas[i], "");				
			}
			// y 
			trainData[sampleSize][column] = transInputY(rowDatas[column -1], "");
			sampleSize ++;
		}				
	}
	
	private double[] computePartialDerivative() {
		double[] partialDerivative = new double[theta.length];
		
		for (int j = 0; j < theta.length; j++) {
			partialDerivative[j] = computePartialDerivativeForTheta(j);
		}
		
		return partialDerivative;
	}
	
	private double computePartialDerivativeForTheta(int j) {
		double sum = 0.0;
		for (int i = 0; i < row; i++) {
			sum += computeAlgorithm(i, j);
		}
		return sum/row;
	}
	
	private double computeAlgorithm (int i, int j) {
		double[] rowData = trainData[i];
		double result = 0.0;
		
		for (int k = 0; k < rowData.length -1; k++) {
			result += theta[k] * rowData[k];
		}
		
		result -= rowData[rowData.length -1];	
		result *= rowData[j];
		return result;
		
	}
	
	private void computeForesightResult(double[] foresightData) {
		Double result = theta[0];
		for (int i = 0; i < foresightData.length; i++) {
			result += theta[i + 1] * foresightData[i];
		}
		
		Integer resultInt = result.intValue();
    	System.out.println(resultInt);
	}
		
	private int transInput2Integer(String input, String message) {
		Integer integerInput = null;
		try {
			integerInput = Integer.parseInt(input);			
		} catch (NumberFormatException e) {
			System.out.println(message + input);
		}	
		return integerInput;
	}
	
	private double transInputFeature(String input, String message) {
		Double doubleInput = null;
		try {
			doubleInput = Double.parseDouble(input);			
		} catch (NumberFormatException e) {
			System.out.println(message + input);
		}	
		
		// validate row data:特征数据化(取值0-1之间)
		if (doubleInput > 1 || doubleInput < 0) {
			System.out.println(FEATURE_VALUE_MESSAGE);
		}
		
		return doubleInput;
	}
	
	private double transInputY(String input, String message) {
		Double doubleInput = null;
		try {
			doubleInput = Double.parseDouble(input);			
		} catch (NumberFormatException e) {
			System.out.println(message + input);
		}	
		
		return doubleInput;
	}


}
