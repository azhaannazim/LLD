package org.examples.SOLID.LSP_ISP;

class EditableDoc implements Document, Editable {
    private String data;

    public EditableDoc(String data) {
        this.data = data;
    }

    @Override
    public void open() {
        System.out.println("Editable Document opened. Data: " + preview());
    }

    @Override
    public void save(String newData) {
        this.data = newData;
        System.out.println("Document saved.");
    }

    @Override
    public String getData() {
        return data;
    }

    private String preview() {
        return data.substring(0, Math.min(data.length(), 20)) + "...";
    }
}