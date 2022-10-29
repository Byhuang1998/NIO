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
        Path path = Paths.get("G:\\testFile\\test01.txt");
        System.out.println(path);
    }
}
