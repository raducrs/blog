export class BlogEntryDetail {
    id: number;
    title: string;
    snipet: string;
    snipet_image: string;
    keywords: string[];
    dateCreated: Date;
    links: {
        __self: string;
    };
}