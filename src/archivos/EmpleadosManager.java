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
 * @author David
 */
public class EmpleadosManager 
{
    RandomAccessFile rcods, remps;
    
    public EmpleadosManager(){
        try{
            //1 Asegurar que el folder company exista
            File f = new File("company");
            f.mkdir();
            //2 Instanciar los RAfs dentro de company
            rcods= new RandomAccessFile("company/codigos.emp","rw");
            remps= new RandomAccessFile("company/empleados.emp","rw");
            //3 Inicicializar el archivo de codigos si es nuevo
            initCodes();
        }
        catch(IOException e){
            System.out.println("No deberia de pasar esto");
        }
    }

    private void initCodes() throws IOException
    {
        if(rcods.length()==0){
            rcods.write(1);
        }
    }
    private int getCode() throws IOException{
      rcods.seek(0);
      int cod= rcods.readInt();
      rcods.seek(0);
      rcods.writeInt(cod+1);
      return cod;
      
    }
    public void addEmployee(String nom, double sal)throws IOException
    {
        //Me aseguro que el puntero este en al final
        remps.seek(remps.length());
        //codigo
        int code = getCode();
        remps.write(code);
        //Nombre
        remps.writeUTF(nom);
        //Salario
        remps.writeDouble(sal);
        //Fecha de contratacion
        remps.writeLong(Calendar.getInstance().getTimeInMillis());
        //Fecha de despido
        remps.writeLong(0);
        //Aseguremos sus archivos individuales
        createEmployeeFolders(code);
    }
    private String employeeFolder(int code) {
        return "company/empleado"+code;
    }

    private void createEmployeeFolders(int cod)throws IOException {
       //Creando folder empleado+code
       File f = new File(employeeFolder(cod)); 
       f.mkdir();
       
       createYearSalesFileFor(cod);
       
    }
    private RandomAccessFile salesFileFor(int cod) throws IOException{
       String dirPadre= employeeFolder(cod);
       int añoActual= Calendar.getInstance().get(Calendar.YEAR);
       String path= dirPadre+"/ventas"+añoActual+".emp";
       return new RandomAccessFile(path,"rw"); 
    }

    private void createYearSalesFileFor(int cod) throws IOException {
       RandomAccessFile ventas = salesFileFor(cod);
       
       if(ventas.length()==0){
           for(int s=0;s<12; s++){
               ventas.writeDouble(0);
               ventas.writeBoolean(false);
           }
       }
       
       
    }
    /**
     * Imprime:
     * Codigo-Nombre-Salario-Contratacion
     * de todos los empleados NO despedidos
     * @throws IOException 
     */
    public void employeeList() throws IOException{
        remps.seek(0);
        while(remps.getFilePointer()<remps.length()){
            int c = remps.readInt();
            String n = remps.readUTF();
            double sal = remps.readDouble();
            Date fecha = new Date(remps.readLong());
            if(remps.readLong()==0){
                System.out.println(c+"-"+n+" Lps."+sal+" Contratado el: "+fecha);
            }
        }
        
    }
    /**
     * Funcion de busqueda
     * buscara dentro del archivo enps de empleados si existe un empleado con
     * ese codigo de parametro o no
     *  Si lo encuentro
     *      - Dejo el puntero despues de su codigo
     * NOTA: un Empleado Despedido no esta activo
     * 
     * @param cod Codigo del empleado a buscar
     * @return True si lo encontro o False si no
     */
    private boolean isEmployeeActive(int cod) throws IOException{
        remps.seek(0);
        
        while(remps.getFilePointer()< remps.length()){
            int c = remps.readInt();
            long pos = remps.getFilePointer();
            remps.readUTF();
            remps.skipBytes(16);
            
            if(remps.readLong()==0 && c==cod){
                remps.seek(pos);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Despide un empleado que exista con ese codigo 
     * @param code El codigo del empleado a despedir
     * @return True si lo pude despedir o no
     */
    public boolean fireEmployee(int code) throws IOException{
        if(isEmployeeActive(code)){
            String n=remps.readUTF();
            remps.skipBytes(16);
            remps.writeLong(new Date().getTime());
            System.out.println("Depidiendo a"+n);
            return true;
            
        }
        return false;
    
    }
    
    /**
     * -Buscar ese empleado
     * --Sumarle el monto recibido a las ventas del mes actual
     * @param cod
     * @param v 
     */
    public void addSaleToEmployee(int cod, double v) throws IOException{
        if(isEmployeeActive(cod)){
            RandomAccessFile sales = salesFileFor(cod);
        }
    }
    
}
