package com.didi.日记总结;

/**
 * @author zhenglin
 *  
 * @desc %%转义%
 * @date 2021/1/14 下午5:12
 */
public class TestFormat {
    public static void main(String[] args) {
        String json = "[\n" +
                "  {\n" +
                "    \"businessId\": 554,\n" +
                "    \"leaseType\": \"fixed\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金及服务费立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您还车时剩余租期≤1个月，当期租金及服务费不退。\",\n" +
                "          \"若您还车时剩余租期＞1个月，剩余已缴纳未使用租期的租金及服务费退还，但需缴纳1个月租金及服务费作为提前退车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您逾期还车，需要缴纳逾期还车期间的租金，即逾期还车费=日租金*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金在您还车后30个工作日内根据费用结算情况退还。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 554,\n" +
                "    \"leaseType\": \"arbitraryFixed\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金及服务费立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您合同到期前还车，当期租金及服务费不退。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"押金在您还车后30个工作日内根据费用结算情况退还。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 554,\n" +
                "    \"leaseType\": \"arbitraryFlexible\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"提前预约还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您想要还车，需提前15日在APP上预约还车，不产生还车违约金。\",\n" +
                "          \"若您未提前15日预约还车（即提交预约还车的时间与实际还车时间的间隔不足15日），需缴纳违约金=[15天-(实际还车日期-操作预约还车日期)]*(日租金+日服务费)，日租金按首期计算。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金在您还车后30个工作日内根据费用结算情况退还。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 554,\n" +
                "    \"leaseType\": \"newFlexibleRule\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金及服务费立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您提前还车，剩余未使用天数的租金我们将全部退还，但需缴纳剩余租期租金的20%%作为提前退车违约金\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您逾期还车，需要缴纳逾期还车期间的租金，即逾期还车费=日租金*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金在您还车后30个工作日内根据费用结算情况退还。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 554,\n" +
                "    \"leaseType\": \"flexible\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"提前预约还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您想要还车，需提前15日在app上预约还车，不产生还车违约金。\",\n" +
                "          \"若您未提前15日预约还车（即提交预约还车的时间与还车时间的间隔不足15日），需缴纳违约金=（15-提前预约还车天数）*（日租金+日服务费）\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金在您还车后30个工作日内根据费用结算情况退还。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 553,\n" +
                "    \"leaseType\": \"fixed\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您还车时剩余租期≤1个月，当期租金不退。\",\n" +
                "          \"若您还车时剩余租期＞1个月，剩余已缴纳未使用租期的租金退还，但需缴纳1个月租金作为提前退车违约金。\",\n" +
                "          \"若您购买百万保障服务，提前还车百万保障服务费不作退还\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您逾期还车，需要缴纳逾期还车期间的租金，即逾期还车费=日租金*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金会在还车后根据结算情况退还， 如有违约金及未支付费用，将扣除后退还剩余押金。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 553,\n" +
                "    \"leaseType\": \"flexible\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"提前预约还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您想要还车，需提前7日在app上预约还车，不产生还车违约金。\",\n" +
                "          \"若您未提前7日预约还车（即提交预约还车的时间与还车时间的间隔不足7日），需缴纳违约金=（7-提前预约还车天数）*日租金\",\n" +
                "          \"若您购买百万保障服务，提前还车百万保障服务费不作退还\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金会在还车后根据结算情况退还，如有违约金及未支付费用，将扣除后退还剩余押金。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 553,\n" +
                "    \"leaseType\": \"blueshield\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您提前还车，当期租金不退。\",\n" +
                "          \"若您购买百万保障服务，提前还车百万保障服务费不作退还\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您逾期还车，需要缴纳逾期还车期间的租金，即逾期还车费=日租金*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金会在还车后根据结算情况退还， 如有违约金及未支付费用，将扣除后退还剩余押金。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 553,\n" +
                "    \"leaseType\": \"afterBlueshield\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金及服务费立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您还车时剩余租期≤1个月，当期租金及服务费不退；\",\n" +
                "          \"若您还车时剩余租期>1个月，需缴纳1个月租金及服务费作为提前退车违约金。\",\n" +
                "          \"若您购买百万保障服务，提前还车百万保障服务费不作退还\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您逾期还车，需要缴纳逾期还车期间的租金及服务费，即逾期还车费=（日租金+日服务费）*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"车辆押金和违章押金分别在您还车后3个工作日和30个工作日内根据费用结算情况退还。\",\n" +
                "          \". 车辆押金用于还车后如产生违约金及未支付费用的抵扣\",\n" +
                "          \". 违章押金用于还车30个工作日内如产生违章违约金及未支付费用的抵扣\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"businessId\": 553,\n" +
                "    \"leaseType\": \"newFlexible\",\n" +
                "    \"returnCarRule\": [\n" +
                "      {\n" +
                "        \"summary\": \"到期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若您按合同到期日还车，租金及服务费立即停止计费，不产生还车违约金。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"提前还车\",\n" +
                "        \"content\": [\n" +
                "          \"您可以选择随时还车，租期未满申请还车，需缴纳违约金%s元。\",\n" +
                "          \"若您购买百万保障服务，提前还车百万保障服务费不作退还\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"逾期还车\",\n" +
                "        \"content\": [\n" +
                "          \"若逾期还车，需缴纳逾期还车费用=2*（日租金+日服务费）*逾期天数。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"summary\": \"还车押金\",\n" +
                "        \"content\": [\n" +
                "          \"押金会在您还车后3个工作日内和30个工作日内根据费用结算情况分批退还。\",\n" +
                "          \"车辆押金用于抵扣用车中的违约金及未缴纳的费用。\",\n" +
                "          \"违章押金用于抵扣还车30个工作日内产生的违章违约金及未缴纳费用。\",\n" +
                "          \"如应付费用超过车辆押金总额，超出部分将直接从违章押金中扣除。\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        System.out.println(String.format(json, 2));
    }
}
