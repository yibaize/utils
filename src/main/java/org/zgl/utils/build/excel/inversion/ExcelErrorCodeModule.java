package org.zgl.utils.build.excel.inversion;


import org.zgl.utils.build.excel.initjavaobj.DataTableMessage;
import org.zgl.utils.desc.DataTable;

@DataTable
public class ExcelErrorCodeModule implements DataTableMessage {
    private final int id;
    private final String name;
    private final String value;

    public ExcelErrorCodeModule() {
        this.id = 0;
        this.name = "";
        this.value = "";
    }

    public ExcelErrorCodeModule(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public void AfterInit() {

    }
}