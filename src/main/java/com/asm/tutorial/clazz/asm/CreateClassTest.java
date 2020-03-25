package com.asm.tutorial.clazz.asm;

import com.google.common.io.Files;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

public class CreateClassTest {
    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_7, ACC_PUBLIC,
                "pkg/Comparable", null, "java/lang/Object",
                new String[]{"pkg/Mesurable"});

        cw.visitField(ACC_PUBLIC + ACC_STATIC, "hello", "I", null, null).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_STATIC, "helloworld", "Ljava/lang/String", null, null).visitEnd();

        cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "hello", "(IZ)V", null, null).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        File f = new File("./build/Comparable.class");
        Files.asByteSink(f).write(b);
    }

}
