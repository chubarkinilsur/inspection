package ru.iteco.reportutility.infrastructure;

import ru.iteco.reportutility.infrastructure.transformers.*;
import ru.iteco.reportutility.models.ReportConfig;

/**
 * DataTransformerCreator.
 *
 * @author Ilya_Sukhachev
 */
public class DataTransformerCreator { // фабрика

    public static DataTransformer createTransformer(ReportConfig config) { // chain of responsibility
        DataTransformer service = new ConfigDataTransformer(config);

        if (config.isWithData()) {
            service = new WithDataReportTransformer(service);
        }

        if (config.isVolumeSum()) {
            service = new VolumeSumReportTransformer(service);
        }

        if (config.isWeightSum()) {
            service = new WeightSumReportTransformer(service);
        }

        if (config.isCostSum()) {
            service = new CostSumReportTransformer(service);
        }

        if (config.isCountSum()) {
            service = new CountSumReportTransformer(service);
        }

        return service;
    }

}
