package com.demo.JVM;

/**
 * @ClassName Demo0
 * @Description 逃逸分析与栈上分配
 * @Author liujianko
 * @Date 2019-8-5
 **/
public class Demo0 {

    private Demo0 obj;

    /* 方法返回Demo0对象，发生逃逸 */
    public Demo0 getObj(){
        return obj == null? new Demo0() : obj;
    }

    /* 为成员属性赋值，发生逃逸 */
    public void setObj(){
        this.obj = new Demo0();
    }

    /* 对象的作用于仅在当前方法有效，没有发生逃逸 */
    public void use(){
        Demo0 d = new Demo0();
    }

    /* 引用成员属性的值，发生逃逸 */
    public void use2(){
        Demo0 d = getObj();
    }
}
