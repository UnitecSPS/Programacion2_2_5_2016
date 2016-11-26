/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Justm
 */
public class EmpleadosManager {
    RandomAccessFile rcod, remps;
    
    public EmpleadosManager(){
        File fl=new File("company");
        fl.mkdir();
        try{
            rcod=new RandomAccessFile("company/codigos.emp", "rw");
            remps=new RandomAccessFile("company/empleados.emp", "rw");
            initCodes();
        } catch (IOException e){
            System.out.println("Esto no debería pasar");
        }
        
    }
    
    public final void initCodes() throws IOException{
        if (rcod.length()==0){
            rcod.writeInt(0);
        }
    }

    private int getCode() throws IOException{
        int x ;
        rcod.seek(0);
        x= rcod.readInt();
        rcod.seek(0);
        rcod.writeInt(x+1);
        return x;
    } 
    
    public void addEmployee(String name, double salario) throws IOException{
        remps.seek(remps.length());
        int x= getCode();
        remps.writeInt(x);
        remps.writeUTF(name);
        remps.writeDouble(salario);
        remps.writeLong(Calendar.getInstance().getTimeInMillis());
        remps.writeLong(0);
        createEmployeeFolders(x);
    }
    private String employeeFolders(int x) {
        return "company/Empleado"+x;
    }

    private void createEmployeeFolders(int x)  throws IOException {
        File f=new File(employeeFolders(x));
        f.mkdir();
        createYearSalesFileFor(x);
        
    }
    
    private void createYearSalesFileFor(int x) throws IOException{
        RandomAccessFile femp;
        femp = this.salesFileFor(x);
        if (femp.length()==0){
            for(int y=0; y<12; y++){
                femp.writeDouble(0);
                femp.writeBoolean(false);
            }
        }
    }
    
    public void employeeList( ) throws IOException {
        remps.seek(0);
        while(remps.getFilePointer()<remps.length()){
            remps.readInt();
            String nombre= remps.readUTF();
            double salario= remps.readDouble();
            Date fecha = new Date (remps.readLong());
            if (remps.readLong()==0){
                System.out.println("-"+nombre+ " Lps. "+salario+ " contratado el "+fecha);
            }   
        }
    }
    
    private boolean isEmployeeActive(int code) throws IOException {
        remps.seek(0);
        while(remps.getFilePointer()<remps.length()){
            int y=remps.readInt();
            long x= remps.getFilePointer();
            remps.readUTF();
            remps.skipBytes(y);
            long des= remps.readLong();
            if (des==0 && y==code){
               remps.seek(x);
                return true;
            }      
        } return false;
    }
    
    public boolean fireEmployee(int code) throws IOException {
        if (isEmployeeActive(code)){
            remps.readUTF();
            remps.skipBytes(16);
            remps.writeLong(Calendar.getInstance().getTimeInMillis());
            return true;
        } return false; 
    }
    
    private RandomAccessFile salesFileFor(int code) throws IOException{
        String dirPadre= this.employeeFolders(code);
        int year= Calendar.getInstance().get(Calendar.YEAR);
        return new RandomAccessFile(dirPadre+"/Ventas"+year+".emp", "rw");
    }
    
    public void addSaleToEmployee(int code, double sal) throws IOException{
        if (this.isEmployeeActive(code)){
            RandomAccessFile sales= this.salesFileFor(code);
        }
    }
}
