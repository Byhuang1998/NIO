package com.byhuang.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/29 23:57
 * @description TODO
 */
public class PathDemo {

    public static void main(String[] args) {
        Path path = Paths.get("../pipe/PipeDemo.java");
        Path path1 = path.toAbsolutePath();
        System.out.println(path);
        System.out.println(path1);
    }
}
