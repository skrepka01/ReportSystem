package ry.reportsystem.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ry.reportsystem.ReportSystem;
import ry.reportsystem.model.Complaint;
import ry.reportsystem.service.ReportServiceImpl;
import ry.reportsystem.util.Constants;

import java.time.LocalDate;

@NoArgsConstructor
public class Report implements CommandExecutor {


    @Getter
    private Complaint complaint;

    private ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

    @Getter
    public static long id = 0L;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String playerName = args[0];
        String message = "";
        if (args.length == 0) {
            player.sendMessage("Введите аргументы");
        }
        for (int i = 1; i < args.length; i++) {
            if (message.equals("")) {
                message += args[i];
            } else message += " " + args[i];
        }
        if (message.equals("") || message.equals(" ")) {
            player.sendMessage("Вы не заполнили все аргументы");
            return false;
        }
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            if (player1.isOp()) {
                player.sendMessage(Constants.REPORT_NAME + " " + playerName + " " + message);
            } else player1.sendMessage(Constants.REPORT_NAME + " Репорт успешно отправлен");
        }
        ++id;
        LocalDate localDate = LocalDate.now();
        complaint = new Complaint(id, player.getDisplayName(), playerName, message, localDate);
        ReportSystem.reportCache.put(id, complaint);
        saveReports();
        return true;
    }

    private void saveReports() {
        Complaint complaint = ReportSystem.reportCache.getIfPresent(Report.getId());
        assert complaint != null;
        reportServiceImpl.saveReport(complaint);
    }
}


