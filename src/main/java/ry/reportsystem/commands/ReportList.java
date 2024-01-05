package ry.reportsystem.commands;

import lombok.NoArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ry.reportsystem.model.Complaint;
import ry.reportsystem.service.ReportServiceImpl;
import ry.reportsystem.util.Constants;


@NoArgsConstructor
public class ReportList implements CommandExecutor {

    private final ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.isOp()) {
            for (Complaint complaint : reportServiceImpl.findAllReports()) {
                if (complaint != null) {
                    player.sendMessage(Constants.REPORT_LIST + " " +complaint.toString());
                }
            }

        } else player.sendMessage("У вас недостаточно прав");
        return false;
    }
}
