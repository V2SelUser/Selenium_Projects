package iConnectX_Auto_Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestReport {
	static String FileNameWithPath = null;
	public static void WriteReport(String ReportLine){		
		BufferedWriter bufferedWriter = null;
        try {
            FileWriter writer = new FileWriter(FileNameWithPath, true);
            bufferedWriter = new BufferedWriter(writer); 
            bufferedWriter.write(ReportLine);
            bufferedWriter.newLine();
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {bufferedWriter.close();}catch(IOException e) {}
			
		}
		
	}
	

}
