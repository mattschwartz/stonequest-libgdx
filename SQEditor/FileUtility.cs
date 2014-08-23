using SQEditor.Properties;
using System;

namespace SQEditor
{
    public class FileUtility
    {
        public static string GetXMLRootPath()
        {
            return Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + Resources.XMLFolder;
        }

        public static string GetResourcesRootPath()
        {
            return Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + Resources.ResourceFolder;
        }
    }
}
