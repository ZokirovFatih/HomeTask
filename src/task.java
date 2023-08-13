import java.io.*;

public class task {

    public static void main(String[] args) throws IOException {
        System.out.println("copyFile ");
        copyFile();
        System.out.println();
        System.out.println("searchWord ");
        searchWord("Java", "resources/random.txt");
        System.out.println();
        System.out.println("replaceWorld");
        replaceWorld("Java", "Python", "resources/random.txt");
        System.out.println();
        copyFile();
    }

    public static void copyFile() throws IOException{
        FileInputStream in = null;
        try {
            in = new FileInputStream("resources/random.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            in.close();
        }
    }

    public static void searchWord(String word, String fileName) throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(fileName));
        String line;
        int count=0;
        while ((line=reader.readLine())!=null){
            if (line.contains(word)){
                count++;
                System.out.println("Найдено слово \""+word+"\" \"\\\" в строке: " + line);
            }
        }
        reader.close();
        System.out.println ("Всего найдено " + count + " совпадений слова \"" + word + "\" в файле " + fileName);
    }

    public static void replaceWorld(String oldWorld, String newWorld, String fileName) throws IOException{
        File file=new File(fileName);
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String line;
        String content = "";
        while ((line=reader.readLine())!=null){
            content+=line+"\r\n";
        }
        reader.close();
        content=content.replaceAll(oldWorld, newWorld);

        FileWriter writer=new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}
