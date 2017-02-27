package sample.arjay;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Users/ASUS/Documents/stock/test");
		ReadableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ);
		Path pathTo = Paths.get("C:/Users/ASUS/Documents/stock/test.csv");
		WritableByteChannel channelTo = Files.newByteChannel(pathTo,
				new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE });

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while ((channel.read(buffer)) > 0) {
			buffer.flip();
			channelTo.write(buffer);
			buffer.flip();
		}

		channel.close();
		channelTo.close();
	}
}
