using SQEditor.GameObjects;
using SQEditor.GameObjects.Items;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace SQEditor
{
    public class XMLUtility
    {
        public static void Save(Serializable data)
        {
            string path;
            XDocument doc = new XDocument();

            path = FileUtility.GetXMLRootPath() + data.GetType() + ".xml";
            doc = LoadOrCreate(data, path);

            doc.Root.Add(data.ToXML());
            doc.Save(path, SaveOptions.None);

            data.Save();
        }

        private static XDocument LoadOrCreate(Serializable data, string path)
        {
            if (File.Exists(path)) {
                return XDocument.Load(path);
            }

            XDocument result = new XDocument(new XDeclaration("1.0", "utf-8", null));
            result.Add(new XElement(data.GetType()));

            return result;
        }
    }
}
