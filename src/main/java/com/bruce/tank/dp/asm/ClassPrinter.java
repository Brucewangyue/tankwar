package com.bruce.tank.dp.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class ClassPrinter extends ClassVisitor {
    public ClassPrinter(int api) {
        super(api);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        return super.visitField(access, name, descriptor, signature, value);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties().get("user.dir"));
    }
}
