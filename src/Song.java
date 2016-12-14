import java.io.Serializable;


public class Song implements Serializable{

<<<<<<< HEAD
    /**
	 * 
	 */
=======
>>>>>>> 9d16e6f29224bc7cdb4846bb3b4efbed7e690cc4
	private static final long serialVersionUID = 1L;

    private String songName;
    private String singerName;
    private String releasingCompany;

    public Song() {
    }

    public Song(String songName, String singerName, String releasingCompany) {
        this.songName = songName;
        this.singerName = singerName;
        this.releasingCompany = releasingCompany;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getReleasingCompany() {
        return releasingCompany;
    }

    public void setReleasingCompany(String releasingCompany) {
        this.releasingCompany = releasingCompany;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", singerName='" + singerName + '\'' +
                ", releasingCompany='" + releasingCompany + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        String text =  songName + singerName + releasingCompany;
        return text.hashCode();
    }
}
