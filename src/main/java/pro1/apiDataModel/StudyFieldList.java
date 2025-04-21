package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudyFieldList {
    @SerializedName("prijimaciObor")
    public List<StudyField> items;
}
