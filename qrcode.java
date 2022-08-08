import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class qrcode {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String data = "ce qu'on veut coder!";
		int size = 800;
		BitMatrix bitmat = generateMatrix(data,size);
		String imagefmt = "png";
		String outputFileName = "C:\\Users\\Durand kushiki\\Desktop\\finCode." + imagefmt; //écrire dans la file
		writeImage (outputFileName, imagefmt, bitmat);
		System.out.println("Code qr généré avec succès !");
		
	}
	
	private static BitMatrix generateMatrix(String data, int size)
	{
		BitMatrix bitmat=null;
		try {
			bitmat = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE,size,size);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bitmat;
		
	}
	
	private static void writeImage (String outputFileName, String imagefmt, BitMatrix bitmat)
	{
		FileOutputStream fops=null;
		try {
			fops = new FileOutputStream(new File(outputFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			MatrixToImageWriter.writeToStream(bitmat, imagefmt, fops);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fops.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
