package ooad.admin;

import java.util.Map;

// ISP: only report generation here
public interface IReportAdmin {
    Map<String, Object> generateReport();
}