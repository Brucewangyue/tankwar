package com.bruce.tank.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * observer - hook - listener - callback 都是观察者
 */
public class T01_Button {

    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new ActionListener1());
        button.pressButton();
    }
}

/**
 * 事件源
 */
class Button {
    List<ActionListener> actionListeners = new ArrayList<>();

    void pressButton() {
        ActionEvent<Button> event = new ActionEvent<>(this);
        for (ActionListener listener : actionListeners)
            listener.actionPerformed(event);
    }

    void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }
}

class ActionEvent<T> {
    long timeSpan;
    T source;

    public ActionEvent(T t) {
        this.source = t;
        timeSpan = System.currentTimeMillis();
    }

    public T getSource() {
        return source;
    }
}

/**
 * 观察者
 */
interface ActionListener<T> {
    void actionPerformed(ActionEvent<T> actionEvent);
}

/**
 * 观察者 -实现
 */
class ActionListener1 implements ActionListener<Button>{
    @Override
    public void actionPerformed(ActionEvent<Button> actionEvent) {
        Button source = actionEvent.getSource();

        System.out.println("ActionListener1 收到按下通知");
    }
}