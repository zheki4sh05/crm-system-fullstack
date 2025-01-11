import { SelectEntity } from "../select/Select"

export type Stage=SelectEntity & {
    description:string,
    groupId:string,
    order:number
}