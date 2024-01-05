package ry.reportsystem.service;

import ry.reportsystem.model.Complaint;

import java.util.List;

public interface ReportService {

   void saveReport(Complaint complaint);

    Complaint findReportsByName(String playerName);

    List<Complaint> findAllReports();
}
