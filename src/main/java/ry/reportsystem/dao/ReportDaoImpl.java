package ry.reportsystem.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ry.reportsystem.model.Complaint;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ReportDaoImpl implements ReportDao{
    @Getter
    public static List<Complaint> complaints = new ArrayList<>();

    @Override
    public void saveReport(Complaint complaint) {
        complaints.add(complaint);
    }

    @Override
    public Complaint findReportsByName(String playerName) {
        Complaint comp = null;
        for(Complaint complaint : complaints)
        {
           if (complaint.getRecipient().equals(playerName))
           {
               comp = complaint;
           }
        }
        return comp;
    }

    public static List<Complaint> findAllReports() {
        return complaints;
    }
}
