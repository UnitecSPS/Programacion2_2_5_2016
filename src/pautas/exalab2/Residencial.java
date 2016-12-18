package pautas.exalab2;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by David on 12/16/16.
 */
public class Residencial {
    private String name;
    private Residencia primerCasa;


    public Residencial(String name) {
        this.name = name;
        primerCasa = null;
    }


    public boolean numeroDisponible(int num) {
        Residencia tmp = primerCasa;

        while (tmp != null) {
            if (tmp.code == num) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

    public void construirResidencia(int num, String n) {
        Residencia r = new Residencia(num, n);

        if (primerCasa == null) {
            primerCasa = r;
        } else {

            Residencia tmp = primerCasa;
            if (numeroDisponible(num)) {
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = r;
                r.prev = tmp;
            }
        }
    }

    public void agregarInquilino(int num, String inq) {
        Residencia tmp = primerCasa;

        while (tmp != null) {
            if (tmp.code == num) {
                tmp.addInquilino(inq);
            }
            tmp = tmp.next;
        }
    }

    public void informacionCasa(int num) {
        Residencia tmp = primerCasa;
        while (tmp != null) {
            if (tmp.code == num) {
                tmp.print();
                if (tmp.prev != null)
                    System.out.println("Vecinos izquierda: " + tmp.prev.name);
                if (tmp.next != null)
                    System.out.println("Vecinos derecha: " + tmp.next.name);
                System.out.println("");
            }
            tmp = tmp.next;
        }
    }

    public void backup(String path) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        Residencia tmp = primerCasa;

        while (tmp != null) {
            raf.writeInt(tmp.code);
            raf.writeUTF(tmp.name);
            raf.writeInt(tmp.names.size());
            for (String s : tmp.names) {
                raf.writeUTF(s);
            }
            tmp = tmp.next;
        }
    }

    public void reloadFromBackup(String path) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        primerCasa = null;

        while (raf.getFilePointer() < raf.length()) {
            int code = raf.readInt();
            String fname = raf.readUTF();
            construirResidencia(code, fname);
            int numResidentes = raf.readInt();
            for (int x = 0; x < numResidentes; x++) {
                agregarInquilino(code, raf.readUTF());
            }
        }


    }


}
