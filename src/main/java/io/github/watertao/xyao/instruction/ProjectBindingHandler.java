package io.github.watertao.xyao.instruction;

import io.github.watertao.xyao.infras.AbstractInstructionHandler;
import io.github.watertao.xyao.infras.Instruction;
import io.github.watertao.xyao.infras.MessageEnvironmentEnum;
import io.github.watertao.xyao.infras.XyaoInstruction;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 将群组绑定到某个 jira 项目，或解绑
 * 发起角色： master
 * 发起环境： 群组
 */
@Service("bind-project")
@Instruction(
  syntax = "bind-project [options]... ",
  description = "绑定或解绑某个群组与 JIRA 项目",
  masterOnly = true,
  msgEnv = MessageEnvironmentEnum.ROOM
)
public class ProjectBindingHandler extends AbstractInstructionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProjectBindingHandler.class);

    @Override
    protected Options defineOptions() {

        Options options = new Options();
        options.addOption("u", "unbind", false, "unbind project");
        options.addOption("p", "project", true, "JIRA project id");

        return options;

    }

    @Override
    protected void handle(XyaoInstruction instruction, CommandLine command) {

        if (command.hasOption("u")) {
            unbind(instruction);
        } else if (command.hasOption("p") && command.getOptionValue("p") != null) {
            bind(instruction, command.getOptionValue("p"));
        }

    }

    private void unbind(XyaoInstruction instruction) {

    }

    private void bind(XyaoInstruction instruction, String projectId) {

    }


}
