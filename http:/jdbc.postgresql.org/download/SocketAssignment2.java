package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.HttpURLConnection;
import java.net.URL;

public class SocketAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String server = args[ 0 ]; //Argument 1 - This will Store the Server name from Command Line Argument
		String path = args[ 1 ]; //Argument 2 - This will store the path of Stream
		int port = Integer.parseInt(args[ 2 ]); //Argument 3 - This will store the port of Stream
		
		//Creating Temp Directory
		String tmpdir = System.getProperty("java.io.tmpdir");
	    System.out.println("Temp file path: " + tmpdir);
		
	
		try {
			//Socket socket = new Socket( server, port );//Opening Connection to the Socket
			
			/*
			 * PrintStream will write the data
			 * Input Stream will read the data
			 * */
			//PrintStream pS = new PrintStream( socket.getOutputStream() );
            ///BufferedReader br = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            
            // Follow the HTTP protocol of GET <path> HTTP/1.0 followed by an empty line
            //pS.println( "GET " + path + " HTTP/1.0" );
            //pS.println();

            // Read data from the server until we finish reading the document
            //String line = br.readLine();
            
            //Create a Temp File
            URL url = new URL(server);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            int responseCode = httpConn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String fileName = "";
                String disposition = httpConn.getHeaderField("Content-Disposition");
                //String contentType = httpConn.getContentType();
                //int contentLength = httpConn.getContentLength();
                
                if (disposition != null) {
                    // extracts file name from header field
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10,
                                disposition.length() - 1);
                    }
                } else {
                    // extracts file name from URL
                    fileName = server.substring(server.lastIndexOf("/") + 1,
                    		server.length());
                }
                InputStream inputStream = httpConn.getInputStream();
                String saveFilePath = tmpdir + File.separator + fileName;
                 
                // opens an output stream to save into file
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);
     
                int bytesRead = -1;
                byte[] buffer = new byte[4000];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                outputStream.close();
                inputStream.close();
     
                System.out.println("File downloaded");
                
            }
            
            /*File temp = File.createTempFile("hello", ".txt");
            System.out.println("Temp file : " + temp);/*This part can be removed*/
            
            /*BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            
            
            while( line != null ){
            	bw.write(line);
                System.out.println( line );/*This part can be removed
                line = br.readLine();
            }*/

            //Closing all connections
            //br.close();
            //pS.close();
            //bw.close();
            //socket.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
