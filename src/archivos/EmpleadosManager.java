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
    RandomAccessFile rcods, remps;
    public EmpleadosManager(){
        try{
            //1- Asegurar que el folder company exista
            File f = new File("company");
            f.mkdir();
            //2- Instanciar los RAFs dentro de company
            rcods = new RandomAccessFile("company/codigos.emp", "rw");
            remps = new RandomAccessFile("company/empleados.emp", "rw");
            //3- Inicializar el archivo de codigos si es nuevo
            initCodes();
        }
        catch(IOException e){
            System.out.println("No deberia de pasar esto");
        }
    }

    private void initCodes() throws IOException
    {
        if(rcods.length() == 0){
            rcods.writeInt(1);
        }
    }
    
    private int getCode()throws IOException{
        rcods.seek(0);
        int code = rcods.readInt();
        rcods.seek(0);
        rcods.writeInt(code+1);
        return code;
    }
    
    public void addEmployee(String nom, double sal) throws IOException{
        //me aseguro que el puntero este al final
        remps.seek( remps.length() );
        //codigo
        int code = getCode();
        remps.writeInt(code);
        //nom
        remps.writeUTF(nom);
        //salario
        remps.writeDouble(sal);
        //fecha contratacion
        remps.writeLong( Calendar.getInstance().getTimeInMillis() );
        //fecha despido
        remps.writeLong(0);
        //aseguremos sus archivos individuales
        createEmployeeFolders(code);
    }
    
    private String employeeFolder(int code){
        return "company/empleado"+code;
    }
    
    private void createEmployeeFolders(int code) throws IOException
    {
        //crear folder empleado+code
        File edir = new File( employeeFolder(code) );
        edir.mkdir();
        //cre
        createYearSalesFileFor(code);
    }
    
    private RandomAccessFile salesFileFor(int code)throws IOException{
        String dirPadre = employeeFolder(code);
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        String path = dirPadre+"/ventas"+yearActual+".emp";
        
        return new RandomAccessFile(path, "rw");
    }

    private void createYearSalesFileFor(int code)throws IOException
    {
        RandomAccessFile ryear = salesFileFor(code);
        
        if( ryear.length() == 0){
            for (int s = 0; s < 12; s++)
            {
                ryear.writeDouble(0);
                ryear.writeBoolean(false);
            }
        }
    }
    
    /**
     * Imprime:
     * Codigo-Nombre-Salario-Contratacion
     * De todos los empleados NO despedidos
     */
    public void employeeList()throws IOException{
        remps.seek(0);
        while(remps.getFilePointer() < remps.length()){
            int ce = remps.readInt();
            String n = remps.readUTF();
            double sal = remps.readDouble();
            Date fecha = new Date(remps.readLong());
            
            if(remps.readLong() == 0){
                System.out.println(ce+"-"+n+" Lps."+sal+
                        " Contratado el: "+fecha);
            }
        }
    }
    
    /**
     * Funcion de busqueda:
     * Buscara dentro del archivo de empleados si existe
     * un empleado con ese codigo de parametro o no.
     * Si lo encuentro:
     *  - Dejo el púntero justo despues de su codigo 
     * NOTA: Un Empleado Despedido no esta Activo
     * @param code Codigo del empleado a buscar
     * @return True si lo encontro o False si no.
     */
    private boolean isEmployeeActive(int code) throws IOException{
        remps.seek(0);
        
        while(remps.getFilePointer() < remps.length()){
            int ce = remps.readInt();
            long pos = remps.getFilePointer();
            remps.readUTF();
            remps.skipBytes(16);
            
            if(remps.readLong() == 0 && ce == code){
                remps.seek( pos );
                return true;
            }
        }
        return false;
    }
    
    /**
     * Despide un empleado que existe con ese codigo
     * @param code El codigo del empleado a despedir
     * @return True si lo pude despedir o no
     */
    public boolean fireEmployee(int code)throws IOException{
        if(isEmployeeActive(code)){
            String n = remps.readUTF();
            remps.skipBytes(16);
            remps.writeLong( new Date().getTime() );
            System.out.println("Despidiendo a "+n);
            return true;
        }
        return false;
    } 
    
    /**
     * 1- Buscar ese empleado
     *  1.1- Sumarle el monto recibido a las ventas del mes actual
     * @param code
     * @param v 
     */
    public void addSaleToEmployee(int code, double v) throws IOException{
        if(isEmployeeActive(code)){
            RandomAccessFile sales = salesFileFor(code);
        }
    } 
    
   
}
