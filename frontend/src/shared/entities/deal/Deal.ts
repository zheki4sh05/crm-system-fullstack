import { Customer } from "../customer/Customer";
import { Group } from "../group/Group";
import { Stage } from "../stage/Stage";
import { Worker } from "../worker/Worker";
import { Order } from "./order/Order";
import { Source } from "./source/Source";
import { Task } from "./task/Task";

export interface Deal{
    id:string,
    name:string,
    description:string,
    stageId:string,
    orderList:Array<Order>,
    started:number,
    customer:Customer,
    tasks:Array<Task>,
    worker:Worker,
}

export type AboutDeal={

}

export type MoreAboutDeal={
    source: Source,
    group: Group,
    stage?: Stage,
}