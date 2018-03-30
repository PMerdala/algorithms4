package pl.pmerdala.algs4.io;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class In {
    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE=Locale.US;

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    private static final Pattern EVERYTHINK_PATTERN = Pattern.compile("\\A");

    private Scanner scanner;


    public In(){
        this(System.in,CHARSET_NAME,LOCALE);
    }

    public In(@NotNull Socket socket){
        this(socket,CHARSET_NAME,LOCALE);
    }

    public In(@NotNull URL url){
        this(url,CHARSET_NAME,LOCALE);
    }

    public In(@NotNull File file){
        this(file,CHARSET_NAME,LOCALE);
    }

    public In(@NotNull String name){
        this(name,CHARSET_NAME,LOCALE);
    }

    public In(@NotNull Scanner scanner){
        this.scanner = scanner;
    }

    public In(@NotNull InputStream inputStream,@NotNull String charsetName, @NotNull Locale locale ){
        scanner =  createScanner(inputStream,charsetName,locale);
    }

    public In (@NotNull Socket socket,@NotNull String charsetName, @NotNull Locale locale){
        try(InputStream inputStream = socket.getInputStream()){
            scanner =  createScanner(inputStream,charsetName,locale);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open socket " + socket, e );
        }
    }

    public In(@NotNull URL url,@NotNull String charsetName, @NotNull Locale locale){
        scanner = createScanner(url,charsetName,locale);
    }

    public In(@NotNull File file, @NotNull String charsetName, @NotNull Locale locale){
        try(InputStream inputStream  =  new FileInputStream(file)){
            scanner = createScanner(inputStream,charsetName,locale);
        } catch (FileNotFoundException e) {
           throw new IllegalArgumentException("Could not open file " + file, e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open file " + file, e);
        }
    }

    public In(@NotNull String name, @NotNull String charsetName, @NotNull Locale locale){
        InputStream inputStream = getInputStreamFromFilename(name);
        if (inputStream!=null){
            scanner = createScanner(inputStream,charsetName,locale);
            return;
        }
        URL url = getURLFromName(name);
        if (url ==null) throw new IllegalArgumentException("Could not open url from name " + name);
        scanner = createScanner(url,charsetName,locale);
    }

    /** Return true if this scanner exists */
    public boolean exists(){
        return scanner!=null;
    }

    /** return true if input is empty (except possibly whitespace)
        Use this to know whether the next call to {@link #readString()},
        {@link #readDouble()}, ect will succeed.
     */
    public boolean isEmpty(){
        return !scanner.hasNext();
    }

    /** return true if scanner has next line
        Use this method to know whether the next call to {@link #readLine()} will succeed

     */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }


    /** return true if scanner has next line
        Use this method to know whether the next call to {@link #readChar()} will succeed

     */
    public boolean hasNextChar(){
        return scanner.hasNext(EMPTY_PATTERN);
   }

   /** read and return next line in this scanner */
   public String readLine(){
        String line;
        try {
            line = scanner.nextLine();
        }catch (NoSuchElementException e){
            line = null;
        }
        return line;
   }

    /** read and return next character in this scanner */
   public char readChar(){
        String ch = scanner.next(EMPTY_PATTERN);
        assert ch.length() == 1 : "Internal (Std) In.readChar() error!" + " Please contact the authors.";
        return ch.charAt(0);
   }

   /** read and return the remainder of this scanner,as a string */
   public String readAll(){
       if (!scanner.hasNextLine()) return "";
       return scanner.next(EVERYTHINK_PATTERN);
   }

   public String readString(){
       try {
           return scanner.next();
       } catch(NoSuchElementException e){
           throw new NoSuchElementException("attempts to read a 'String' value from input stream, but there are no more tokens available");
       }
   }

   /**
   * Read the next token from this input stream, parses it as a {@code int}, and returns the {@code int}.
   * @return the next {@code int} in this input stream
   * @throws NoSuchElementException if the input stream is empty
   * @throws InputMismatchException if the next token cannot be parsed as an {@code int}
    */
   public int readInt(){
       try {
           return scanner.nextInt();
       } catch (InputMismatchException e){
           String token = scanner.next();
           throw new InputMismatchException("attemps to read an 'int' value from input stream, but the next token is \"" + token +"\"");
       } catch(NoSuchElementException e){
           throw new NoSuchElementException("attempts to read a 'int' value from input stream, but there are no more tokens available");
       }

   }
    /**
     * Read the next token from this input stream, parses it as a {@code double}, and returns the {@code double}.
     * @return the next {@code int} in this input stream
     * @throws NoSuchElementException if the input stream is empty
     * @throws InputMismatchException if the next token cannot be parsed as an {@code double}
     */
    public double readDouble(){
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e){
            String token = scanner.next();
            throw new InputMismatchException("attemps to read an 'double' value from input stream, but the next token is \"" + token +"\"");
        } catch(NoSuchElementException e){
            throw new NoSuchElementException("attempts to read a 'double' value from input stream, but there are no more tokens available");
        }

    }

    /**
     * Read the next token from this input stream, parses it as a {@code float}, and returns the {@code float}.
     * @return the next {@code int} in this input stream
     * @throws NoSuchElementException if the input stream is empty
     * @throws InputMismatchException if the next token cannot be parsed as an {@code float}
     */
    public float readFloat(){
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e){
            String token = scanner.next();
            throw new InputMismatchException("attemps to read an 'float' value from input stream, but the next token is \"" + token +"\"");
        } catch(NoSuchElementException e){
            throw new NoSuchElementException("attempts to read a 'float' value from input stream, but there are no more tokens available");
        }

    }

    /**
     * Read the next token from this input stream, parses it as a {@code long}, and returns the {@code long}.
     * @return the next {@code int} in this input stream
     * @throws NoSuchElementException if the input stream is empty
     * @throws InputMismatchException if the next token cannot be parsed as an {@code long}
     */
    public long readLong(){
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e){
            String token = scanner.next();
            throw new InputMismatchException("attemps to read an 'long' value from input stream, but the next token is \"" + token +"\"");
        } catch(NoSuchElementException e){
            throw new NoSuchElementException("attempts to read a 'long' value from input stream, but there are no more tokens available");
        }

    }

    private Scanner createScanner(@NotNull URL url, @NotNull String charsetName, @NotNull Locale locale){
        Scanner scanner;
        try{
            URLConnection site = url.openConnection();
            InputStream inputStream = site.getInputStream();
            scanner =  createScanner(inputStream,charsetName,locale);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open url " + url, e);
        }
        return scanner;

    }

    private Scanner createScanner(@NotNull InputStream inputStream,@NotNull String charsetName, @NotNull Locale locale){
        Scanner scanner = new Scanner(new BufferedInputStream(inputStream),charsetName);
        scanner.useLocale(locale);
        return scanner;
    }

    private InputStream getInputStreamFromFilename(@NotNull String name){
        try{
            File file = new File(name);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                return fis;
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Could not open name " + name, e);
        }
        return null;
    }

    private URL getURLFromName(@NotNull String name){
        URL url = getClass().getResource(name);
        if (url == null){
            url = getClass().getClassLoader().getResource(name);
        }
        if (url==null){
            try {
                url = new URL(name);
            } catch (MalformedURLException e) {
               throw new IllegalArgumentException("Could not Open url from name " + name,e);
            }
        }
        return url;
    }
}
