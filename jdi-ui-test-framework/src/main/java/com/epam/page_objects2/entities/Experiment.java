package com.epam.page_objects2.entities;

import com.epam.page_objects2.enums.AssayTypes;

import java.util.ArrayList;
import java.util.List;

import static com.epam.page_objects2.enums.AssayTypes.*;
import static com.epam.ui_test_framework.utils.common.PrintUtils.print;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

/**
 * Created by Maksim_Palchevskii on 6/5/2015.
 */
public class Experiment {
    public static Experiment defaultExperiment = new Experiment();

    public String id;
    public String name = "autotest MCT default experiment name";
    public String project = "Amplex Red";
    public String target = "ELISA";
    public AssayTypes assayType = FLUORESCENCE;
    public String source = "IVT";
    public String cellLine;
    public String date;
    public String cellPassage;
    public String cellCount;
    public String attachments;
    public String comment;
    public String transfectedDate;
    public String transfectedBy;

    public String platemap;
    public String readout;

    public String blotImage;
    public String transfection;
    public String sampleIdentifiers;

    public String assayName;
    public String catalogNumber;
    public String lotNumber;

    public String barCode;
    public String proteinExprRes;
    public String result;
    public boolean goodBarCode=false;

    private List<String> changedFields = new ArrayList<>();

    public Experiment setAssayType(AssayTypes value) { assayType = value; changedFields.add("AssayType:" + value); return this; }
    public Experiment setAssayName(String value) { assayName = value; changedFields.add("AssayName:" + value); return this; }
    public Experiment setCatalogNumber(String value) { catalogNumber = value; changedFields.add("CatalogNumber:" + value); return this; }
    public Experiment setLotNumber(String value) { lotNumber = value; changedFields.add("LotNumber:" + value); return this; }
    public Experiment setTarget(String value) { target = value; changedFields.add("Target:" + value); return this; }
    public Experiment setBarCode(String value, Boolean flag) { barCode = value; goodBarCode = flag;
        changedFields.add("BarCode:" + value); changedFields.add("BarCodeFlag:" + value); return this; }
    public Experiment setPlatemap(String value) { platemap = value; changedFields.add("Platemap:" + value); return this; }
    public Experiment setReadout(String value) { readout = value; changedFields.add("Readout:" + value); return this; }
    public Experiment setComment(String value) { comment = value; changedFields.add("Comment:" + value); return this; }
    public Experiment setProtein(String value) { proteinExprRes = value; changedFields.add("ProteinExprRes:" + value); return this; }
    public Experiment setResult(String value) { result = value; changedFields.add("ResultAcceptable:" + value); return this; }

    public Experiment setBlotImage(String value) { blotImage = value; changedFields.add("BlotImage:" + value); return this; }
    public Experiment setTransfection(String value) { transfection = value; changedFields.add("TransfectionControlImages:" + value); return this; }
    public Experiment setSampleIdentifiers(String value) { sampleIdentifiers = value; changedFields.add("SampleIdentifiers:" + value); return this; }

    public Experiment() {
        this.name = "Experiment Name" + currentTimeMillis();
    }


    public Experiment(String name, String Project,String Target, AssayTypes AssayType, String Source, String CellLine, String Date, String CellPassage, String BlotImage, String transfection, String CellCount,
                      String Platemap, String Readout, String Attachments, String Comment, String transfectedDate, String TransfectedBy, String SampleIdentifiers) {
        this.name = name;
        this.project = Project;
        this.target = Target;
        this.assayType = AssayType;
        this.source = Source;
        this.cellLine = CellLine;
        this.date = Date;
        this.cellPassage = CellPassage;
        this.blotImage = BlotImage;
        this.transfection = transfection;
        this.cellCount = CellCount;
        this.platemap = Platemap;
        this.readout = Readout;
        this.attachments = Attachments;
        this.comment = Comment;
        this.transfectedDate = transfectedDate;
        this.transfectedBy = TransfectedBy;
        this.sampleIdentifiers = SampleIdentifiers;
    }

    @Override
    public String toString() {
        return format("Experiment(%s)", print(changedFields));
    }

    public Experiment(AssayTypes assayType, String platemap, String readout) {
        this(assayType);
        setPlatemap(platemap);
        setReadout(readout);
    }
    public Experiment(String platemap, String readout) {
        setPlatemap(platemap);
        setReadout(readout);
    }

    public Experiment(AssayTypes assayType) {
        this();
        setAssayType(assayType);
        switch(assayType) {
            case AMPLEX_RED:
                setAssayName("Name " + assayType);
                setCatalogNumber("PT00037340");
                setLotNumber("1777594.1");
                break;
            case LC_MS:
                setProtein("Protein experiment resource");
                setResult("Acceptable");
                break;
        }
        switch (assayType) {
            case WESTERN_BLOT:
                setBlotImage("FvX08tk0jSk.jpg");
                setTransfection("724804700.jpg");
                setSampleIdentifiers("PT00037331");
                break;
            case AMPLEX_RED:
            case ELISA:
            case FLUORESCENCE:
            case LUMINESCENCE:
                setPlatemap("platemap.xlsx");
                setReadout("readout.csv");
                break;
        }
    }
}
