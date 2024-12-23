package example.hastaneotomasyon.model;


public class Laboratuvar {

    private int laboratuvarId;
    private String testTipi;
    private int hastaId;

    // Getter ve Setter metodları
    public int getLaboratuvarId() {
        return laboratuvarId;
    }

    public void setLaboratuvarId(int laboratuvarId) {
        this.laboratuvarId = laboratuvarId;
    }

    public String getTestTipi() {
        return testTipi;
    }

    public void setTestTipi(String testTipi) {
        this.testTipi = testTipi;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }
}


