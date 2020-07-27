/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.interview.demo.testjol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
 */
public class JOLSample_08_Class {

    /**
     * Another example of special treatment for some fields.
     *
     * If you run this example, you can see the large gap in instance field block.
     * There are no Java fields that could claim that block, hence there are no
     * "hidden" fields, like in the example before. This time, VM "injects" some
     * of the fields into the Class, to store some of the meta-information there.
     *
     * See:
     *  http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/tip/src/share/vm/classfile/javaClasses.hpp
     *  http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/tip/src/share/vm/classfile/javaClasses.cpp
     */

    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(Class.class).toPrintable());
    }
    /*
     * java.lang.Class object internals:
     *  OFFSET  SIZE                                              TYPE DESCRIPTION                               VALUE
     *       0    12                                                   (object header)                           N/A
     *      12     4                     java.lang.reflect.Constructor Class.cachedConstructor                   N/A
     *      16     4                                   java.lang.Class Class.newInstanceCallerCache              N/A
     *      20     4                                  java.lang.String Class.name                                N/A
     *      24     4                                                   (alignment/padding gap)
     *      28     4                       java.lang.ref.SoftReference Class.reflectionData                      N/A
     *      32     4   sun.reflect.generics.repository.ClassRepository Class.genericInfo                         N/A
     *      36     4                                java.lang.Object[] Class.enumConstants                       N/A
     *      40     4                                     java.util.Map Class.enumConstantDirectory               N/A
     *      44     4                    java.lang.Class.AnnotationData Class.annotationData                      N/A
     *      48     4             sun.reflect.annotation.AnnotationType Class.annotationType                      N/A
     *      52     4                java.lang.ClassValue.ClassValueMap Class.classValueMap                       N/A
     *      56    32                                                   (alignment/padding gap)
     *      88     4                                               int Class.classRedefinedCount                 N/A
     *      92     4                                                   (loss due to the next object alignment)
     * Instance size: 96 bytes
     * Space losses: 36 bytes internal + 4 bytes external = 40 bytes total
     * 这4+32的空白填充就很奇怪了，能避免为啥要填，还填这么大？
     *      VM将某些字段“注入”到Class中，以在其中存储一些元信息。
     */
}