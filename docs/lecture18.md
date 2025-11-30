## 旋转

如果节点向左旋转，那么它的右子节点会成为他的父节点
向右旋转相反

## 红黑树
本质是二叉搜索树BST，但是同一个节点的多个元素被red link相连。red link只能存在于左边，不能在右边![[截屏2025-11-30 16.39.09.png]]

![[截屏2025-11-30 16.55.21.png]]
### 红黑树平衡规则
![[截屏2025-11-30 16.55.57.png]]
The runtime analysis for LLRBs is simple if you trust the 2-3 tree runtime.
- ﻿﻿LLRB tree has height O(log N).
- ﻿﻿Contains is trivially O(log N).
- ﻿﻿Insert is O(log N).
- ﻿﻿0(log N) to add the new node.
- ﻿﻿O(log N) rotation and color flip operations per insert.