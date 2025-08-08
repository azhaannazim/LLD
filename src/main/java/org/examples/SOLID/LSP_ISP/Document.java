package org.examples.SOLID.LSP_ISP;

//ISP and LSP are closely aligned.
//
//ISP ensures that interfaces are minimal and relevant.
//LSP ensures that implementations of those interfaces behave correctly and predictably.

interface Document {
    void open();
    String getData();
}