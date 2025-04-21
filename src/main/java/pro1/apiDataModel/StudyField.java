package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

// Automaticky generováno touto stránkou: https://json2csharp.com/code-converters/json-to-pojo => pouze jsem udělla překlad
public class StudyField {
    @SerializedName("eprDeadlinePrihlaska")
    public Deadline eprDeadline;

    @SerializedName("eprDatumOd")
    public Deadline startDate;

    @SerializedName("eprPouzivat")
    public String useEpr;

    @SerializedName("globalIdno")
    public int globalId;

    @SerializedName("kombIdno")
    public int combinationId;

    @SerializedName("misto")
    public String location;

    @SerializedName("nazev")
    public String name;

    @SerializedName("oborIdno")
    public int fieldId;

    @SerializedName("predpisIdno")
    public Object regulationId;

    @SerializedName("rok")
    public String year;

    @SerializedName("stprIdno")
    public int studyProgramId;

    @SerializedName("webUrl")
    public Object webUrl;

    @SerializedName("fakulta")
    public String facultyCode;

    @SerializedName("fakultaTxt")
    public String facultyName;

    @SerializedName("forma")
    public String form;

    @SerializedName("typ")
    public String type;

    @SerializedName("programNazev")
    public String programName;

    @SerializedName("typProgramu")
    public String programType;

    @SerializedName("programKod")
    public String programCode;

    @SerializedName("programJazyk")
    public String programLanguage;

    @SerializedName("oborZkratka")
    public String fieldAbbreviation;

    @SerializedName("oborNazev")
    public String fieldName;

    @SerializedName("eprihlaskaCleanURL")
    public String applicationCleanURL;
}
