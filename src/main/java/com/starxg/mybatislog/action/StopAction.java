package com.starxg.mybatislog.action;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.starxg.mybatislog.gui.MyBatisLogManager;
import org.jetbrains.annotations.NotNull;

/**
 * StopAction
 * @author huangxingguang
 */
public class StopAction extends AnAction {

    private final MyBatisLogManager manager;

    public StopAction(MyBatisLogManager manager) {
        super("Stop", "Stop", AllIcons.Actions.Suspend);
        this.manager = manager;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        manager.stop();
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabled(manager.isRunning());
    }

    /**
     * com.intellij.diagnostic.PluginException: `ActionUpdateThread.OLD_EDT` is deprecated and going to be removed soon. 'com.starxg.mybatislog.action.StopAction' must override `getActionUpdateThread()` and chose EDT or BGT. See ActionUpdateThread javadoc. [Plugin: com.starxg.mybatis-log-plugin-free]
     * 	at com.intellij.diagnostic.PluginProblemReporterImpl.createPluginExceptionByClass(PluginProblemReporterImpl.java:23)
     * 	at com.intellij.diagnostic.PluginException.createByClass(PluginException.java:90)
     * 	at com.intellij.diagnostic.PluginException.reportDeprecatedUsage(PluginException.java:125)
     * 	at com.intellij.openapi.actionSystem.ActionUpdateThreadAware.getActionUpdateThread(ActionUpdateThreadAware.java:21)
     * 	at com.intellij.openapi.actionSystem.AnAction.getActionUpdateThread(AnAction.java:201)
     */
    @Override
    public ActionUpdateThread getActionUpdateThread() {
        // Choose the appropriate thread: EDT or BGT
        return ActionUpdateThread.EDT; // or ActionUpdateThread.BGT
    }
}