
public class DataAnalysisTest {
	
	public static void main(String[] args) {
		/*
		 * 测试代码，negative的输入
		 * 1. 第一行输入3个数字
		 * 2. 第一行输入string，而非数据
		 * 3. 输入的F，N的取值范围与要求不符合
		 * 4. 第二行到N+1输入行数与第一行的N不等
		 * 5. 第二行开始到N+1行输入的内容不是F+1列
		 * 6. 第二行开始到N+1行输入的内容不是数字
		 * 7. 第N+2 行输入待预测行数量的不是数字
		 * 7. 第N+3开始输入的内容不是F+1行，行数不是预测行数量
		 * 8. 第N+1行输入的内容不是数字	
		 * 9. 特征值的范围不是在（0-1）之间      
      	*/
		
		DataAnalysis dataAnalysis = new DataAnalysis();
		dataAnalysis.init();
		dataAnalysis.trainData();
		dataAnalysis.predicate();
	}

}
