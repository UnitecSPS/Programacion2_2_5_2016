package pautas.tg3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

public class Steam {
    private RandomAccessFile codes, games, players;

    public Steam() {
         try{
            File f2= new File("steam/downloads");
            f2.mkdirs();
            codes = new RandomAccessFile("steam/codes.stm", "rw");
            games = new RandomAccessFile("steam/games.stm", "rw");
            players=new RandomAccessFile("steam/players.stm", "rw");
            //3- Inicializar el archivo de codigos si es nuevo
            initCodes();
        }
        catch(IOException e){
            System.out.println("No deberia de pasar esto");
        }
    }
    
     private void initCodes() throws IOException {
        if(codes.length() == 0){
            for(int f=0; f < 3; f++)
                codes.writeInt(1);
        }
    }
    
     private int getCode(long offset)throws IOException{
        codes.seek(offset);
        int code = codes.readInt();
        codes.seek(offset);
        codes.writeInt(code+1);
        return code;
    }
     
    public void addGame(String titulo, char SO, int edadMin, double precio) throws IOException{
         games.seek( games.length());
         int code= getCode(0);
         games.writeInt(code);
         games.writeUTF(titulo);
         games.writeChar(SO);
         games.writeInt(edadMin);
         games.writeDouble(precio);
         games.writeInt(0);
    }
    
    public void addPlayer(String nombre,  Calendar nacimiento) throws IOException {
        players.seek( players.length());
         int code= getCode(4);
         players.writeInt(code);
         players.writeUTF(nombre);
         players.writeLong(nacimiento.getTimeInMillis());
         players.writeInt(0);
    }
    
    public boolean playerExists(int code)throws IOException {
        players.seek(0);
        while(players.getFilePointer() < players.length()){
            if (players.readInt()==code)
                return true;
            players.readUTF();
            players.skipBytes(12);
          }
          return false;
    }
    
    public boolean gameExists(int code)throws IOException {
        games.seek(0);
        while(games.getFilePointer() < games.length()){
            if(games.readInt() == code)
                return true;
            games.readUTF();
            games.skipBytes(18);
          } return false;
    }
    
    private boolean olderEnough(int minimo, long nac){
        Calendar haceMinimo = Calendar.getInstance();
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTimeInMillis(nac);
        
        haceMinimo.add(Calendar.YEAR, -minimo);
        return nacimiento.before(haceMinimo);
    }
    
    private void updateDownloadCounter(RandomAccessFile ram)throws IOException{
        //NOTA: Deberia de estar al inicio del dato del contador!
        int cgd = ram.readInt();
        ram.seek(ram.getFilePointer()-4);
        ram.writeInt(cgd+1);
    }
    
    public boolean downloadGame(int cvg, int ccli, char so) throws IOException {
        
        if (gameExists(cvg) && playerExists(ccli)){
            //Game Info
            String title = games.readUTF();
            char gso = games.readChar();
            int minimo = games.readInt();
            double prec = games.readDouble();
            
            //player info
            String name = players.readUTF();
            long nac = players.readLong();
            
            if(gso == so && olderEnough(minimo, nac)){
                int code= getCode(8);
                FileWriter fl=new FileWriter("steam/downloads/download_"+code+".stm");
                fl.write(new Date().toString()+"\n");
                fl.write("Download #"+code+"\n");
                fl.write(name+" has bajado "+title+" a un precio de $"+prec+"\n");
                fl.close();
                //actualizar contadores
                updateDownloadCounter(games);
                updateDownloadCounter(players);
                
                return true;
            }
        }
                
        return false;
    }
     
     public void updatePriceFor(int cvg, double newprice) throws IOException{
         if(gameExists(cvg)){
             games.readUTF();
             games.readChar();
             games.readInt();
             games.writeDouble(newprice);
         }
     }
     
     public void reportForClient(int ccli, String txtFile) throws IOException {
         if (playerExists(ccli)){
             FileWriter f= new FileWriter(txtFile);
             f.write("Codigo: "+ccli);
             f.write("Nombre: "+players.readUTF());
             Date nac = new Date(players.readLong());
             f.write("Fecha de Nacimiento: "+nac);
             f.write("Contador de descargas: "+players.readInt());
             f.close();
             System.out.println("REPORTE CREADO!");
         } else{
             System.out.println("NO SE PUDO CREAR EL REPORTE");
         }
     }
     
      public void printGames() throws IOException{
        games.seek(0);
        while(games.getFilePointer() < games.length()){
            System.out.print("CODIGO: "+games.readInt());
            System.out.print("NOMBRE: "+games.readUTF());
            System.out.print("SISTEMA OPERATIVO: "+games.readChar());
            System.out.print("EDAD MINIMA: "+games.readInt());
            System.out.print("PRECIO: "+games.readDouble());
            System.out.println("DESCARGAS: "+games.readInt());         
        }
    }
          
}
