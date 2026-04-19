package com.yanjianghua.logistics.entity;

import java.util.Scanner;
import com.yanjianghua.logistics.entity.Order;
import com.yanjianghua.logistics.enums.ShippingTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 程序启动入口（控制台版本）
 * ================== 设计讲解 ==================
 * 1. 这个类是 Day 1 的临时脚手架，目的是让你在没学 Spring Boot 时
 *    就能看到自己的代码跑起来，验证实体类设计是否正确。
 * 2. 未来我们会把这个控制台交互替换成 Spring Boot 的 REST API，
 *    但业务逻辑层（Service）的调用方式是相同的。
 * 3. main 方法中的菜单循环是典型的控制台程序模式，
 *    用 while + switch 实现不同功能的跳转。
 * 4. createDemoOrder() 方法模拟了用户下单场景，
 *    展示了如何用代码创建一个完整的订单对象。
 */
public class LogisticsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("====================================");
        System.out.println(" 义乌智能物流订单与派单系统 v0.1 ");
        System.out.println("====================================");

        while (!exit) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleOrderManagement(scanner);
                    break;
                case "2":
                    handleRuleManagement(scanner);
                    break;
                case "3":
                    handleProviderManagement(scanner);
                    break;
                case "0":
                    exit = true;
                    System.out.println("感谢使用，再见！");
                    break;
                default:
                    System.out.println("无效选项，请重新输入。");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n请选择功能模块：");
        System.out.println("1. 订单管理");
        System.out.println("2. 计费规则管理");
        System.out.println("3. 承运商管理");
        System.out.println("0. 退出");
        System.out.print("请输入数字选择：");
    }

    // ==================== 订单管理子菜单 ====================
    private static void handleOrderManagement(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- 订单管理 ---");
            System.out.println("1. 新增订单（模拟创建）");
            System.out.println("2. 查看所有订单（待实现）");
            System.out.println("3. 计算运费（待实现）");
            System.out.println("0. 返回主菜单");
            System.out.print("请选择：");
            String sub = scanner.nextLine();

            switch (sub) {
                case "1":
                    Order demoOrder = createDemoOrder();
                    System.out.println("模拟订单创建成功！订单信息如下：");
                    System.out.println("订单编号：" + demoOrder.getOrderNo());
                    System.out.println("寄件地址：" + demoOrder.getSenderAddress());
                    System.out.println("收件地址：" + demoOrder.getReceiveAddress());
                    System.out.println("邮寄方式"+demoOrder.getShippingType().getDescription());
                    System.out.println("货物重量：" + demoOrder.getWeight() + " kg");
                    System.out.println("订单状态：" + demoOrder.getStatus());
                    break;
                case "2":
                    System.out.println("功能开发中，敬请期待...");
                    break;
                case "3":
                    System.out.println("功能开发中，敬请期待...");
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("输入错误。");
            }
        }
    }

    /**
     * 创建一个模拟订单对象
     * 场景：义乌档口老板寄往杭州的普通快递
     */
    private static Order createDemoOrder() {
        Order order = new Order();


        // 模拟生成订单号：YT + 当前时间戳（确保唯一性）
        order.setOrderNo("YT" + System.currentTimeMillis());

        // 寄件人信息
        order.setSenderName("张三（义乌商贸城档口）");
        order.setSenderPhone("13800001111");
        order.setSenderAddress("义乌市北苑街道望道路300号");

        // 收件人信息
        order.setReceiveName("李四");
        order.setReceivePhone("13900002222");
        order.setReceiveAddress("杭州市西湖区文三路100号");

        // 货物信息（核心）
        order.setShippingType(ShippingTypeEnum.STANDARD);
        order.setWeight(new BigDecimal("8.5"));      // BigDecimal 必须用字符串构造
        order.setVolume(new BigDecimal("0.08"));
        order.setInsured(false);

        // 状态与时间
        order.setStatus("PENDING_PRICING");
        order.setCreatedTime(LocalDateTime.now());

        // 承运商暂未分配
        order.setProviderId(null);

        return order;
    }

    // ==================== 计费规则管理（占位） ====================
    private static void handleRuleManagement(Scanner scanner) {
        System.out.println("\n--- 计费规则管理 ---");
        System.out.println("此处将展示规则列表、新增规则等功能（Day 2 实现）");
        System.out.println("按 Enter 返回...");
        scanner.nextLine();
    }

    // ==================== 承运商管理（占位） ====================
    private static void handleProviderManagement(Scanner scanner) {
        System.out.println("\n--- 承运商管理 ---");
        System.out.println("此处将展示承运商列表、状态变更等功能（Day 3 实现）");
        System.out.println("按 Enter 返回...");
        scanner.nextLine();
    }
}
