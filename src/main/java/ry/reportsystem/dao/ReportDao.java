package ry.reportsystem.dao;

import org.bukkit.entity.Player;
import ry.reportsystem.model.Complaint;

import java.util.List;

public interface ReportDao {

   void saveReport(Complaint  complaint);

    Complaint findReportsByName(String playerName);

    //List<Complaint> findAllReports();
}
