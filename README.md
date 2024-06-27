
# Electric Vehicle Route Optimization for Urban Deliveries

This project aims to optimize the routing of electric vehicles for deliveries in urban areas. The objective is to minimize the total distance traveled and the overall cost, considering the limitations of vehicle capacity and battery autonomy.

## Table of Contents

- [Introduction](#introduction)
- [Problem Description](#problem-description)
- [Graph Modeling](#graph-modeling)
- [Algorithm Description](#algorithm-description)
- [Experiments](#experiments)
- [Results](#results)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

The rapid increase in CO2 emissions has necessitated the exploration of more sustainable logistics solutions. This project applies graph theory concepts to optimize the delivery routes of electric vehicles, aiming to reduce both environmental impact and operational costs.

## Problem Description

The problem involves optimizing the logistics of delivery operations by considering several factors:
- Delivery time
- Shipping cost
- Battery recharge points
- Minimizing the number of trips

The goal is to maximize the number of deliveries per vehicle, starting from a central depot and covering the shortest possible routes.

## Graph Modeling

The graph model includes the following key components:
- **Customer (Vertex)**: Represents the delivery points with specific demands.
- **Vehicle (Edge)**: Represents the vehicle's capacity and route.
- **Recharge Points**: Locations where vehicles can recharge their batteries.
- **Depot**: The starting point of all routes, represented as the central node.

The graph-based algorithms help to model and solve the vehicle routing problem, ensuring optimized and efficient logistics operations.

## Algorithm Description

The project uses the Clarke & Wright Savings Algorithm, a heuristic method for solving the vehicle routing problem. The steps are as follows:

1. **Calculate Savings**: Compute the savings for merging routes.
2. **Sort Savings**: Order savings in descending order.
3. **Initialize Routes**: Start with each customer in a separate route.
4. **Merge Routes**: Combine routes based on savings, respecting vehicle capacity constraints.
5. **Repeat**: Continue until no more routes can be merged.

The algorithm was implemented in Java, using randomly generated test data for validation.

## Experiments

Experiments were conducted on a personal computer with the following specifications:
- **Processor**: Intel i5 10th (6 cores, 12 threads)
- **Memory**: 16GB DDR4 3200MHz
- **Storage**: 500GB SSD NVMe
- **Graphics**: GTX 1050Ti
- **OS**: PopOS 22.04

Two test scenarios were created to simulate real-world conditions, considering the vehicle's capacity and battery autonomy.

## Results

The results demonstrate the effectiveness of the Clarke & Wright algorithm in optimizing delivery routes. The total distance traveled and the number of deliveries were significantly improved, respecting the constraints of vehicle capacity and battery life.

### Scenario 1
- **Route 0**: Total distance: 36.715 km, Total demand: 41
- **Route 1**: Total distance: 21.633 km, Total demand: 28
- **Route 2**: Total distance: 34.286 km, Total demand: 38
- **Route 3**: Total distance: 39.858 km, Total demand: 40
- **Route 4**: Total distance: 40.644 km, Total demand: 40

### Scenario 2
- **Route 0**: Total distance: 26.076 km, Total demand: 42
- **Route 1**: Total distance: 38.470 km, Total demand: 35
- **Route 2**: Total distance: 36.055 km, Total demand: 26
- **Route 3**: Total distance: 32.666 km, Total demand: 46
- **Route 4**: Total distance: 54.325 km, Total demand: 49

## Conclusion

The project successfully applied graph theory and the Clarke & Wright algorithm to optimize the routing of electric vehicles for urban deliveries. This approach reduces operational costs and environmental impact by minimizing the distance traveled and optimizing resource utilization.

## References

1. Oliveira, R. A. de C., & Delgado, K. V. (2015). Sistema para roteamento de veículos capacitados aplicando Métodos de Monte Carlo. iSys - Brazilian Journal of Information Systems, 8(3), 42–63. [DOI: 10.5753/isys.2015.290](https://sol.sbc.org.br/journals/index.php/isys/article/view/290).
2. Clarke, G., & Wright, J. W. (1964). Scheduling of vehicles from a central depot to a number of delivery points. Operations Research, 12(4), 568-581. [DOI: 10.1287/opre.12.4.568](https://doi.org/10.1287/opre.12.4.568).
3. Li, X., et al. (2020). A survey of electric vehicle routing and charging optimization: Models, algorithms, and applications. Energies, 13(4), 873. [MDPI](https://www.mdpi.com/2071-1050/12/24/10537).
4. Hu, Q., Su, X., Ren, T., & Luo, Z. (2019). Electric vehicle routing problem: A review of models, algorithms, and applications. Journal of Cleaner Production, 208, 925-946. [HEP](https://journal.hep.com.cn/fem/EN/10.1007/s42524-021-0157-1).

For more details, please refer to the [full report](https://github.com/franklaercio/eletric-vehicle-route/blob/main/article/Roteamento%20de%20ve%C3%ADculos%20el%C3%A9tricos%20para%20entregas%20em%20%C3%A1reas%20urbanas.pdf).
