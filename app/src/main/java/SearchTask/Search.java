package SearchTask;

import android.os.Bundle;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.drew.sp22.cst438_project01_starter.AppStorage.SearchDatabase;
import com.daclink.drew.sp22.cst438_project01_starter.R;
@Entity(tableName = SearchDatabase.SEARCH_TABLE)
public class Search  {

    @PrimaryKey(autoGenerate = true)
    private int searchID;
    private String lyrics;
    private String APIresults;

    public Search(String lyrics, String APIresults) {
        this.lyrics = lyrics;
        this.APIresults = APIresults;
    }

    public int getSearchID() {
        return searchID;
    }

    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getAPIresults() {
        return APIresults;
    }

    public void setAPIresults(String APIresults) {
        this.APIresults = APIresults;
    }
}