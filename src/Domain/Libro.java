
package Domain;

import java.io.File;


public class Libro {
    
    private int isbn;
    private Metadata metadata;
    private File file;

    public Libro(int isbn, Metadata metadata, File file) {
        this.isbn = isbn;
        this.metadata = metadata;
        this.file = file;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    
}
