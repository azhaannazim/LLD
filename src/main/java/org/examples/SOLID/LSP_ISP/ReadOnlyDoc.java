package org.examples.SOLID.LSP_ISP;

public class ReadOnlyDoc implements Document{
    private final String data;

    public ReadOnlyDoc(String data) {
        this.data = data;
    }

    @Override
    public void open() {
        System.out.println("Read-Only Document opened. Data: " + preview());
    }

    @Override
    public String getData() {
        return data;
    }

    private String preview() {
        return data.substring(0, Math.min(data.length(), 20)) + "...";
    }
}
