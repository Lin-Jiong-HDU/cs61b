
## 一些概念性的东西
![[截屏2025-11-20 14.04.10.png]]
## B-tree

### 名称的由来

![[截屏2025-11-20 14.41.24.png]]
### B树的L
![[截屏2025-11-20 14.42.53.png]]
### Runtime

![[截屏2025-11-20 14.52.54.png]]
### Insert

1️⃣ 找到应插入的叶子节点； 

2️⃣ 将键插入该节点； 

3️⃣ 若节点未超出容量（≤ m-1），结束； 

4️⃣ 若超出容量，**执行[分裂](https://zhida.zhihu.com/search?content_id=266011122&content_type=Article&match_order=1&q=%E5%88%86%E8%A3%82&zd_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ6aGlkYV9zZXJ2ZXIiLCJleHAiOjE3NjM3OTUxNTUsInEiOiLliIboo4IiLCJ6aGlkYV9zb3VyY2UiOiJlbnRpdHkiLCJjb250ZW50X2lkIjoyNjYwMTExMjIsImNvbnRlbnRfdHlwZSI6IkFydGljbGUiLCJtYXRjaF9vcmRlciI6MSwiemRfdG9rZW4iOm51bGx9.xYxk7oNy037jOGD_PjBHkpMxxUORrUV_hqaDaUgPI0M&zhida_source=entity)（Split）**：

- 将中间键提升到父节点；
- 分裂成两个子节点； 

5️⃣ 若父节点也满，则递归向上分裂，直至根节点； 

6️⃣ 若根节点分裂，生成新根，树高 +1。

### Delet

删除更复杂，分为三种情况：

1. **目标键在叶子节点** → 直接删除；
2. **目标键在内部节点** → 用前驱或后继替换，再删除对应叶节点；
3. **删除后节点关键字不足（<⌈m/2⌉-1）** → 执行**[借键](https://zhida.zhihu.com/search?content_id=266011122&content_type=Article&match_order=1&q=%E5%80%9F%E9%94%AE&zd_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ6aGlkYV9zZXJ2ZXIiLCJleHAiOjE3NjM3OTUxNTUsInEiOiLlgJ_plK4iLCJ6aGlkYV9zb3VyY2UiOiJlbnRpdHkiLCJjb250ZW50X2lkIjoyNjYwMTExMjIsImNvbnRlbnRfdHlwZSI6IkFydGljbGUiLCJtYXRjaF9vcmRlciI6MSwiemRfdG9rZW4iOm51bGx9.Q6unOp6PV8JZZq9cVOEmtyJ0AxVTD5ts0nawEDzMxRo&zhida_source=entity)（Rotate）** 或 **[合并](https://zhida.zhihu.com/search?content_id=266011122&content_type=Article&match_order=1&q=%E5%90%88%E5%B9%B6&zd_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ6aGlkYV9zZXJ2ZXIiLCJleHAiOjE3NjM3OTUxNTUsInEiOiLlkIjlubYiLCJ6aGlkYV9zb3VyY2UiOiJlbnRpdHkiLCJjb250ZW50X2lkIjoyNjYwMTExMjIsImNvbnRlbnRfdHlwZSI6IkFydGljbGUiLCJtYXRjaF9vcmRlciI6MSwiemRfdG9rZW4iOm51bGx9.PrPgcZYpiCETY3MXcCLxKmU_vsyFTajgJp7RXt-fJkM&zhida_source=entity)（Merge）** 操作来维持平衡。

### 对比
![[截屏2025-11-20 15.14.20.png]]