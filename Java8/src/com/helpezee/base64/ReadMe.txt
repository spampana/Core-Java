The Base64 Encoding is an encoding scheme which uses 64 printable characters (A-Za-z0-9+/) to replace each character in original 
String in an algorithmic way so that it can be decoded later. The process which converts original String to something else is 
known as encoding and the reverse process to convert an encoded String to original content is known as decoding.

The base64 is one of the oldest encoding scheme, which prevents misuse of data by encoding into ASCII format. 
Even though there are more advanced encoding and encryption schemes available 
e.g. MD5 or RSH-SHA, Base64 is the best for simple encoding needs.

There are a couple of ways to Base64 encode a String in Java e.g. 

by using Java 6's javax.xml.bind.DatatypeConverter#printBase64Binary(byte[]) 
or
by using Apache Commons Codec's Base64.encodeBase64(byte[) and Base64.decodeBase64(byte[])as shown here, 
 or
the infamous Sun's internal base64 encoder and decoder, sun.misc.BASE64Encoder().encode() and sun.misc.BASE64Decoder().decode(), 
there was no standard way in JDK API itself. 


The JDK 8 API contains a Base64 class in java.util package which supports both encoding and decoding text in Base64


Java 8 now has inbuilt encoder and decoder for Base64 encoding.
---------------------------------------------------------------

In Java 8, we can use three types of Base64 encoding 

Simple/Basic : Output is mapped to a set of characters lying in A-Za-z0-9+/. 
			   The encoder does not add any line feed in output, and the decoder rejects any character other than A-Za-z0-9+/.

URL: Output is mapped to set of characters lying in A-Za-z0-9+_. 
	 It uses the URL and Filename safe base64 alphabet and does not add any line separation. 
	 This alphabet does not use special characters used in URLs like ‘/’

MIME: Output is mapped to MIME friendly format. Output is represented in lines of no more than 76 characters each, 
	  and uses a carriage return '\r' followed by a linefeed '\n' as the line separator. 
	  No line separator is present to the end of the encoded output.
	  
	  
The reason for that is the character used in Basic encoding is not URL safe or filename 
e.g. it uses "\" as one of the encoding character, which is a valid character in URL and PATH. 

The URL base64 encoder instead uses - and _ (minus and underscore) to encode a String, which can then be safely attached to a URL. You can use the Base64.getUrlEncoder() method to retrieve a URL base encoder in Java 8. 

Similarly, The MIME encoder generates a Base64 encoded String using the basic alphabets (A-Za-Z0-9) but in an MIME-friendly format: 
each line of the output is no longer than 76 characters and ends with a carriage return followed by a linefeed (\r\n), 
which is not the case with Basic base64 encoding. You can use the Base64.getMimeEncoder() method to retrieve a MIME Base64 encoder. 



Nested Classes
--------------

S.No.		Nested class & Description

1			static class Base64.Decoder
			This class implements a decoder for decoding byte data using the Base64 encoding scheme as specified in RFC 4648 and RFC 2045.

2			static class Base64.Encoder
			This class implements an encoder for encoding byte data using the Base64 encoding scheme as specified in RFC 4648 and RFC 2045.

Methods
-------

S.No.			Method Name & Description

1				static Base64.Decoder getDecoder()
				Returns a Base64.Decoder that decodes using the Basic type base64 encoding scheme.

2				static Base64.Encoder getEncoder()
				Returns a Base64.Encoder that encodes using the Basic type base64 encoding scheme.

3				static Base64.Decoder getMimeDecoder()
				Returns a Base64.Decoder that decodes using the MIME type base64 decoding scheme.

4				static Base64.Encoder getMimeEncoder()
				Returns a Base64.Encoder that encodes using the MIME type base64 encoding scheme.

5				static Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator)
				Returns a Base64.Encoder that encodes using the MIME type base64 encoding scheme with specified line length and line separators.

6				static Base64.Decoder getUrlDecoder()
				Returns a Base64.Decoder that decodes using the URL and Filename safe type base64 encoding scheme.

7				static Base64.Encoder getUrlEncoder()
				Returns a Base64.Encoder that encodes using the URL and Filename safe type base64 encoding scheme.


Important points
-----------------

Based on my experience in Java, following are some worth remembering point about Base64 encoding and decoding:

1) Use Apache Commons' Codec's Base64.encodeBase64() and Base64.decodeBase64() prior to Java 6 for encoding a String in base64 and decoding.

2) Don't use Sun's sun.misc.BASE64Encoder and sun.misc.BASE64Decoder as they are Sun's internal classes and can be removed without any notice. They are also only available on Oracle or Sun JDK, you won't get them in other JVM. Though, they are still lurking around even in Java 8 :-)

3) The difference between Basic and URL Base64 encoder is that later is URL safe. It uses - and _ instead of / and + to encode String which can be used in URL safely. If you know forward slash (/) has a different meaning in URL.

4) The MIME Base64 Encoder generate output which is no longer 76 characters and ends with \r\n

5) In Java 6, you can use also use JAXB's DatatypeConverter for encoding a String into base64 in Java e.g. by using method printBase64Binary(byte[]) of javax.xml.bind.DatatypeConverter class.

6) Make sure you use the same type of Base64 decoder e.g. Basic, URL or MIME which you have used while encoding. Using a different type of encoder will result in error or incorrect output.

Wrapping files
--------------

Java 8 offers the possibility to directly encode strings and store them in a file in one step. 
The method wrap() of the base64 encoders provided by Java receives and OutputStream as parameter 
and returns a wrapped output stream that will manipulate all content that is going to be written to the output stream. 

Here is an example:

String buffer = "oviedin oviedin";
File file = new File( "outputStream.txt" ); //we create a file
OutputStream outputStream = new FileOutputStream( file ); // we pass the file to the output stream
OutputStream wrappedOS = Base64.getEncoder().wrap( outputStream ); // using the file output stream we create a wrapped encoding one
wrappedOS.write( buffer.toString().getBytes( "utf-8" ) ); // all content is encoded

This is the content of the flie:
b3ZpZWRpbiBvdmllZGlu

The opposite operation is also possible, here is shown how to read decode strings contained in a file 
using the wrap() method of the decoders:

InputStream inputStream = new FileInputStream( file );
InputStream unWrappedIS = Base64.getDecoder().wrap( inputStream );

All the content that we read from the un-wrapped InputStream is going to be decoded.
