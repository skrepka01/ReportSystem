package ry.reportsystem.service;

import lombok.NoArgsConstructor;
import ry.reportsystem.dao.ReportDaoImpl;
import ry.reportsystem.model.Complaint;

import java.util.List;

@NoArgsConstructor
public class ReportServiceImpl implements ReportService{

    private static final ReportDaoImpl reportDaoImpl = new ReportDaoImpl();

    @Override
    public void saveReport(Complaint complaint) {
        reportDaoImpl.saveReport(complaint);  //.saveReport(id);
    }

    @Override
    public Complaint findReportsByName(String playerName) {
        return reportDaoImpl.findReportsByName(playerName);
    }

    @Override
    public List<Complaint> findAllReports() {
       return ReportDaoImpl.findAllReports();
    }
}
