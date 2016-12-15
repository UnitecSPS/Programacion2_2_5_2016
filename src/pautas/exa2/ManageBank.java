/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class ManageBank {
    private RandomAccessFile rc;
    
    public ManageBank(){
        try{
            File f = new File("banco");
            f.mkdir();
            rc = new RandomAccessFile("banco/cuentas.bnk", "rw");
        }catch(IOException e){}
    }
    
    public long buscar(int c)throws IOException{
        rc.seek(0);
        while(rc.getFilePointer() < rc.length()){
            if(rc.readInt() == c)
                return rc.getFilePointer();
            rc.readUTF();
            rc.skipBytes(16);
            rc.readUTF();
        }
        return -1;
    }
    
    public void addCuenta(int c, String n, TipoCuenta t)throws IOException, AccountAlreadyExistException{
        if(buscar(c) == -1){
            rc.writeInt(c);
            rc.writeUTF(n);
            rc.writeLong(Calendar.getInstance().getTimeInMillis());
            rc.writeDouble(t.saldoMin);
            rc.writeUTF(t.name());
        }
        else
            throw new AccountAlreadyExistException(c);
    }
    
    public void deposito(int c, double m)throws IOException{
        if(buscar(c) > 0){
            rc.readUTF();
            rc.writeLong(Calendar.getInstance().getTimeInMillis());
            long pos = rc.getFilePointer();
            double s = rc.readDouble();
            rc.seek(pos);
            rc.writeDouble(s+m);
        }
    }
    
    public boolean retiro(int c, double m)throws IOException{
        if(buscar(c) > 0){
            rc.readUTF();
            long pos = rc.getFilePointer();
            rc.readLong();
            double s = rc.readDouble();
            if(s > m){
                rc.seek(pos);
                rc.writeLong(Calendar.getInstance().getTimeInMillis());
                rc.writeDouble(s-m);
                return true;
            }
        }
        return false;
    }
    
    public void registrarIntereses()throws IOException{
        rc.seek(0);
        
        while(rc.getFilePointer() < rc.length()){
            rc.readInt();
            rc.readUTF();
            rc.readLong();
            long pos = rc.getFilePointer();
            double s = rc.readDouble();
            TipoCuenta t = TipoCuenta.valueOf(rc.readUTF());
            //actualizar---
            rc.seek(pos);
            rc.writeDouble(s+(s*t.tasa));
            rc.readUTF();
        }
    }
    
    public void imports(String filename)throws IOException{
        try(FileWriter fw = new FileWriter(filename)){
            rc.seek(0);
            while(rc.getFilePointer() < rc.length()){
                int c = rc.readInt();
                String n = rc.readUTF();
                rc.readLong();
                double s = rc.readDouble();
                String t = rc.readUTF();
                String dato = c+"-"+n+"-Lps. "+s+"-Tipo:"+t;
                fw.write(dato+"\n");
            }
        }
    }
}
