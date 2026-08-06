import{c as s,j as e,d as l}from"./index-CtFqtZmX.js";/**
 * @license lucide-react v0.344.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const i=s("AlertCircle",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["line",{x1:"12",x2:"12",y1:"8",y2:"12",key:"1pkeuh"}],["line",{x1:"12",x2:"12.01",y1:"16",y2:"16",key:"4dfq90"}]]);/**
 * @license lucide-react v0.344.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const x=s("RefreshCw",[["path",{d:"M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8",key:"v9h5vc"}],["path",{d:"M21 3v5h-5",key:"1q7to0"}],["path",{d:"M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16",key:"3uifl3"}],["path",{d:"M8 16H3v5",key:"1cv678"}]]);function o({title:a="Something went wrong",description:n="We could not load this data. Please try again.",onRetry:t,action:r,className:c}){return e.jsxs("div",{className:l("flex flex-col items-center justify-center rounded-2xl surface px-6 py-14 text-center",c),children:[e.jsx("div",{className:"mb-4 flex h-14 w-14 items-center justify-center rounded-2xl bg-error-50 text-error-600 dark:bg-error-500/15 dark:text-error-100",children:e.jsx(i,{size:24})}),e.jsx("h3",{className:"text-base font-semibold text-[var(--text-primary)]",children:a}),e.jsx("p",{className:"mt-1.5 max-w-sm text-sm text-[var(--text-secondary)]",children:n}),r?e.jsx("div",{className:"mt-5",children:r}):t?e.jsxs("button",{onClick:t,className:"mt-5 inline-flex items-center gap-2 rounded-xl bg-brand-accent px-4 py-2.5 text-sm font-semibold text-white shadow-sm transition-all hover:bg-mint-700",children:[e.jsx(x,{size:15}),"Try again"]}):null]})}export{o as E};
